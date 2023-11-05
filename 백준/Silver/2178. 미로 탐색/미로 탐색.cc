#include <iostream>
#include <queue>
using namespace std;
int n, m;
int mat[101][101];
int visited[101][101];
int dy[4] = {1,-1,0,0};
int dx[4] = {0,0,-1,1};

void bfs(int sy, int sx){
    queue<pair<int, int> > q;
    q.push({sy, sx});
    visited[sy][sx] = 1;
    while(!q.empty()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for(int i = 0 ; i < 4; i ++){
            int yy = y + dy[i];
            int xx = x + dx[i];
            if(yy < 0 || xx < 0 || yy >= n || xx >= m) continue;
            if(mat[yy][xx] == 1 && visited[yy][xx] == 0){
                visited[yy][xx] = visited[y][x] + 1;
                q.push({yy, xx});
            }
        }
    }
}

int main(){
	int a;
	cin >> n >> m;
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			scanf("%1d",&mat[i][j]);
		}
	}
	bfs(0,0);
	
    cout << visited[n - 1][m - 1];

}
