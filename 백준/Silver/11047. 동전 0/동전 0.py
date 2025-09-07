target = list(map(int, input().strip().split()))
coin_type = []

for i in range(target[0]):
    coin_type.append(int(input()))
coin_type.sort(reverse=True)

number_of_coin = 0
for j in range(len(coin_type)):
    quotient = target[1] // coin_type[j]
    target[1] -= quotient * coin_type[j]
    number_of_coin += quotient

print(number_of_coin)