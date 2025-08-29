#2557
print('Hello World!')

#10718
print('강한친구 대한육군')
print('강한친구 대한육군')

#10171
print("\    /\\")
print(" )  ( ')")
print('(  /  )')
print(' \(__)|')

#10172
print('|\\_/|')
print('|q p|   /}')
print('( 0 )"""\\')
print('|"^"`    |')
print('||_/=\\\\__|')

#1000
a = str(input())
b = int(a[0:1])
c = int(a[2:])
print(c+b)

a, b = input().split()
print(int(a)+int(b))

#1001
a, b = input().split()
print(int(a)-int(b))

#10998
a, b = input().split()
print(int(a)*int(b))

#1008
a, b = input().split()
print(int(a)/int(b))

a, b = input().split()
print(int(a)%int(b))

#10869
a, b = input().split()
print(int(a)+int(b))
print(int(a)-int(b))
print(int(a)*int(b))
print(int(a)//int(b))
print(int(a)%int(b))

#10430
a, b, c = input().split()
print((int(a) + int(b))%int(c))
print(((int(a)%int(c))+(int(b)%int(c)))%int(c))
print((int(a)*int(b))%int(c))
print(((int(a)%int(c))*(int(b)%int(c)))%int(c))

#2588
a = input()
b = input()

n1 = [int(a[2:3]), int(a[1:2]), int(a[0:1])]
n2 = [int(b[2:3]), int(b[1:2]), int(b[0:1])]

l1 = n2[0] * (n1[0] + n1[1]*10 + n1[2]*100)
l2 = n2[1] * (n1[0] + n1[1]*10 + n1[2]*100)
l3 = n2[2] * (n1[0] + n1[1]*10 + n1[2]*100)

result = l1 + l2*10 +l3*100

print("%d\n%d\n%d\n%d"%(l1, l2, l3, result))