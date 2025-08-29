'''문제
예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.

크로아티아 알파벳	변경
č	            c=
ć	            c-
dž	            dz=
đ	            d-
lj	            lj
nj	            nj
š	            s=
ž	            z=
예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.'''

'''입력
첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
ex)
ljes=njak'''

'''출력
입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
ex)
6'''

# 풀이 1
a = input()
cnt = 0
for i in range(len(a)):
    if a[i] == '=':
        if a[i-2] == 'd' and a[i-1] == 'z': #dz=인 경우
            cnt -= 1
            # print('dz=')
        elif a[i-1] == 'c' or a[i-1] == 'z' or a[i-1] == 's': #c= or z= or s=인 경우
            b=1 #의미없음
            # print('c= or z= or s=')
        else:
            cnt += 1
    elif a[i] == '-':
        if a[i-1] == 'd' or a[i-1] == 'c': #d- or c-인 경우
            b=1 #의미없음
            # print('d- or c-')
        else:
            cnt += 1
    elif a[i] =='j':
        if a[i-1] == 'l' or a[i-1] == 'n': #lj or nj인 경우
            b=1 #의미없음
            # print(i, a[i-1], a[i], 'lj or nj')
        else:
            cnt += 1
    else:
        cnt += 1
print(cnt)

# 풀이 2
a = input()
croatian_alphabet = ['c=', 'c-' ,'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for croatian in croatian_alphabet: # 크로아티아 알파벳을 #으로 변경
    a = a.replace(croatian, '#')
print(len(a))