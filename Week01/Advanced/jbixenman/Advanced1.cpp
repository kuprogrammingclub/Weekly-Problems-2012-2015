#include <iostream>
using namespace std;

const int lp = 10000;//largest place value;

struct IntArray // holds all numbers and largest place value of a given array 
{
    int theArray[lp];
    int places;
    IntArray()
    {
        for(int i = 0;i<lp;i++)
        {
            theArray[i] = 0;
        }
        places = 0;
    }
};

void placeIntoArray(IntArray &A,int x) // places the sequence of integers into array. ex 15: theArray[0] = 5, theArray[1] = 1; 
{
    int i = 0;
    while(x > 0)
    {
        A.theArray[i] = x%10;
        x = x/10;
        i++;
    }
    A.places = i;
    return;
}

void printArray(IntArray A) // prints number and how many places
{
    for(int i = A.places-1;i>=0;i--)
    {
        cout << A.theArray[i];
    }
    cout << " " << A.places << endl;
    return;
}

IntArray add(IntArray A, IntArray B) // adds two arrays together
{
    if(A.places >= B.places)
    {
        for(int i = 0;i<B.places+1;i++)
        {
            int x = A.theArray[i] + B.theArray[i];
            A.theArray[i] = x%10;
            if(x/10 == 1)//carry Over = true
            {
                A.theArray[i+1] += 1;
                if(i+1 >= A.places)
                {
                    A.places++;
                }
            }
        }
        return A;
    }
    else
    {
        for(int i = 0;i<A.places+1;i++)
        {
            int x = B.theArray[i] + A.theArray[i];
            B.theArray[i] = x%10;
            if(x/10 == 1)//carry Over = true
            {
                B.theArray[i+1] += 1;
                if(i+1 >= B.places)
                {
                    B.places++;
                }
            }
        }
        return B;
    }
}

/*
gets final array by using only addition
ex.
    2^3 = 2*2*2
    = (2+2)*2 = 4*2
    = 4+4 = 8
*/
void getFinalArray(IntArray &A,int x, int n) 
{
    int numberOfMultiplications = n-1;
    for(int i = 0;i<numberOfMultiplications;i++)
    {
        int numberOfAdditions = x-1;
        IntArray tempNumber = A;
        for(int j = 0;j<numberOfAdditions;j++)
        {
            A = add(A,tempNumber);
        }
    }
}

int getSum(IntArray A) // gets sum of array
{
    int x = 0;
    for(int i = 0;i<A.places;i++)
    {
        x += A.theArray[i];
    }
    return x;
}

int main()
{
    IntArray answer;
    //IntArray b;
    int x;
    int n;
    
    cout << "Please enter a number and the power it should be taken to." << endl;
    cin >> x >> n;
    
    placeIntoArray(answer,x);
    
    if(x > 0)// checks if x input is valid
    {
        if(n == 0)//checks if n input is valid
        {
            cout << 1 << endl;
        }
        else if(n == 1)
        {
            cout << getSum(answer) << endl; 
        }
        else if(n > 1)
        {
            getFinalArray(answer,x,n);
            cout << getSum(answer) << endl;
        }
        else 
        {
            cout << "The power cannot be negative! Terminating." << endl;
        }    
    }
    else 
    {
        cout << "Number cannot be zero or negative! Terminating." << endl;
    }
    
    
    
    system("pause");
}
