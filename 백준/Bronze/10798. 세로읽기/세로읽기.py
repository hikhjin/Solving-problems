import sys
input = sys.stdin.readline
arr = [list(str(input().rstrip())) for _ in range(5)]
ans = ''

for i in range(15):
    for j in range(5):
        if i < len(arr[j]):
            ans += arr[j][i]

print(ans)