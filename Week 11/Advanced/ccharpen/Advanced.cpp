#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <unordered_set>
#include <string>

using namespace std;

enum RowCol {
    COLUMN,
    ROW
};

struct Street {
    Street() {};
    Street(RowCol r, unsigned int i, vector<string> v) {
        rc = r;
        idx = i;
        holes = v;
    }

    RowCol rc;
    unsigned int idx;
    vector<string> holes; 

    // Functorify
    bool operator() (Street &lhs, Street &rhs) {
        return lhs.holes.size() < rhs.holes.size();
    }
};

string buildKey(const int i, const int j) {
    return to_string(i) +  " " + to_string(j);
}

bool allHolesCovered(vector<string> holes, unordered_set<string> uncoveredHoles) {
    for(string h : holes) {
        if(uncoveredHoles.find(h) != uncoveredHoles.end()) {
            return false;
        }
    }

    return true;
}

// Greedy
void solve(const vector<vector<int>> v, const int n) {
    priority_queue<Street, vector<Street>, Street> q; 
    unordered_set<string> uncoveredHoles; 

    // record holes in each column
    for(int i = 0; i < n; i++) {
        vector<string> holes;

        for(int j = 0; j < n; j++) {
            if(v[i][j] <= 0) {
                uncoveredHoles.insert(buildKey(i, j));
                holes.push_back(buildKey(i, j));
            }
        }  

        q.push(Street(ROW, i, holes));
    }
    
    // record holes in each row
    for(int i = 0; i < n; i++) {
        vector<string> holes;

        for(int j = 0; j < n; j++) {
            if(v[j][i] <= 0) {
                holes.push_back(buildKey(j, i));
            }
        }  

        q.push(Street(COLUMN, i, holes));
    }

    vector<Street> solution;
    Street top;

    // build solution
    while(!uncoveredHoles.empty()) {
        top = q.top();
        q.pop();
        
        if(allHolesCovered(top.holes, uncoveredHoles)) {
            continue;
        }

        solution.push_back(top); 

        for(string c : top.holes) {
            uncoveredHoles.erase(c);
        } 
    } 
        
    // print solution
    for(Street street : solution) {
        cout << (street.rc == ROW ? "Row " : "Column ") 
             << street.idx 
             << " repaired.\n";
    }
}

int main () {
    int n;
    vector<vector<int>> inpt;

    cin >> n;

    for(int i = 0; i < n; i++) {
        inpt.push_back(vector<int>(n));
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> inpt[i][j];
        }  
    }

    solve(inpt, n);
    
    return 0;
}
