#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

//Allocates matrices by reading dimensions and creating
//vector of integer vectors
vector< vector<int> > createMatrix(istream& input) {
    int dim1;
    int dim2;
    input >> dim1;
    input >> dim2;

    //Populate vector with empty integer vectors
    vector< vector<int> > output;
    for(int k = 0; k < dim1; k++)
        output.push_back(vector<int>(dim2));

    //Populate integer vectors with values
    int elem;
    for(int i = 0; i < dim1; i++) {
        for(int j = 0; j < dim2; j++) {
            input >> elem;
            output[i][j] = elem; 
        }
    }

    return output;
}

//Check if multiplication can be performed
bool canMultiply(vector< vector<int> >& matrix1, vector< vector<int> >& matrix2) {
    return matrix1[0].size() == matrix2.size();
}

//Perform naive multiplication
vector< vector<int> > multiply(vector< vector<int> >& matrix1, vector< vector<int> >& matrix2) {
    //Create and populate an multiplicative matrix
    vector< vector<int> > output;
    for (int m = 0; m < matrix1.size(); m++)
        output.push_back(vector<int>(matrix2[0].size()));

    //Multiply
    for(int i = 0; i < matrix1.size(); i++) {
        for(int j = 0; j < matrix2[0].size(); j++) {
            output[i][j] = 0;
            for(int k = 0; k < matrix2.size(); k++) {
                output[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
    }

    return output;
}

//Print each element of a matrix
void print(vector< vector<int> >& matrix) {
    for(int i = 0; i < matrix.size(); i++) {
        for(int j = 0; j < matrix[0].size(); j++) {
            cout << matrix[i][j] << " ";
        }

        cout << "\n";
    }
}

int main(int argc, char** argv) {
    ifstream input;
    input.open(argv[1]);

    vector< vector<int> > matrix1 = createMatrix(input);
    vector< vector<int> > matrix2 = createMatrix(input);

    //Present output
    if(canMultiply(matrix1, matrix2)) {
        cout << "Multiplying the matrices " << endl;
        print(matrix1);
        cout << "and" << endl;
        print(matrix2);
        cout << "results in: " << endl;
        vector< vector<int> > matrix3 = multiply(matrix1, matrix2);
        print(matrix3);
    } 
    else
        cout << "Multiplication cannot be performed, dimension mismatch" << endl;
    
    return 0;
}
