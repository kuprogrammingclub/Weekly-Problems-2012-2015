#include <iostream>

using namespace std;
int N, K, Q;
int* a;
int* idx;

int main() {
	cin >> N >> K >> Q;
	a = new int[N];
	idx = new int[Q];
	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}
	for (int i = 0; i < Q; i++) {
		cin >> idx[i];
	}
	for (int i = 0; i < Q; i++) {
		if (K % N == 0) {
			cout << a[idx[i]] << '\n';
		} 
		else {
			int K_0 = K % N;
			if (idx[i] >= K_0) {
				cout << a[idx[i] - K_0] << '\n';
			} 
			else {
				cout << a[idx[i] + N - K_0] << '\n';
			}
		}
	}
	system("pause");
}