cost = 1260
coin_type = [500, 100, 50, 10]

result = 0

for coin in coin_type:
    result += cost // coin
    cost %= coin

print(result)
