import sys
input = sys.stdin.readline
# sys.recursionlimit(10**6)

n, r, c = map(int, input().split())

def get_status(n, r, c):
    if n == 0:
        return 0
    half = 2**(n-1)
    if r < half and c < half: #Top-Left
        return get_status(n-1, r, c)
    elif r < half and c >= half: #Top-Right
        return half**2 + get_status(n-1, r, c-half)
    elif r>=half and c<half: #Bottom-Left
        return 2*(half**2) + get_status(n-1, r-half, c)
    elif r>=half and c>=half: #Bottom-Right
        return 3*(half**2) + get_status(n-1, r-half, c-half)

status = get_status(n, r, c)
print(status)