'''문제
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.'''

'''입력
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
ex)
3
happy
new
year
'''

'''출력
첫째 줄에 그룹 단어의 개수를 출력한다.
ex)
3
'''

# 풀이 1
n = int(input())
cnt = 0
for i in range(n):
    chk=1
    a = input()
    for j in range(len(a)):
        idx_max = j
        cnt_char = 0
        for k in range(j, len(a)): #현재 지점부터 글자 끝까지
            if a[j] == a[k]: #현재글자와 같은 글자가 있는 맨 마지막 인덱스 찾기
                idx_max = k
                cnt_char += 1
        if idx_max-j+1 != cnt_char: #두 글자의 인덱스 차가 글자 개수와 같지 않으면 그룹 단어가 아님
            chk = 0
            break
    if chk == 1:
        cnt += 1
print(cnt)


# 풀이 2
n = int(input())
cnt = 0
for i in range(n):
    a = input()
    chk = 1
    for j in range(len(a)-1):
        if a[j] != a[j+1]: #현재 글자와 다음 글자가 다르면
            if a[j] in a[j+1:]: #현재 글자가 다음 글자 이후에 또 있으면 그룹 단어가 아님
                chk = 0
                break
    if chk == 1:
        cnt += 1
print(cnt)