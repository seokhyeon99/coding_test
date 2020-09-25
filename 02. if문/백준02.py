#1330
a, b = input().split()
if int(a) > int(b):
    print(">")
elif int(a) < int(b):
    print("<")
else:
    print("==")
    
#9498
score = int(input())
if score >= 90:
    print("A")
elif score >= 80:
    print("B")
elif score >= 70:
    print("C")
elif score >= 60:
    print("D")
else:
    print("F")
    
#2753
year = int(input())
if year%400 == 0:
    print("1")
elif year%100 == 0:
    print("0")
elif year%4 == 0:
    print("1")
else:
    print("0")
    
#14681
x = int(input())
y = int(input())
if(x>0 and y>0):
    print("1")
elif x>0 and y<0:
    print("4")
elif x<0 and y>0:
    print("2")
elif x<0 and y<0:
    print("3")
else:
    print("on the line")
    
#2884
h, m = input().split()
h = int(h)
m = int(m)
if m>=45:
    print("%d %d" %(h, m-45))
elif h==0:
    print("23 %d" %(m+15))
else:
    print("%d %d" %(h-1, m+15))
