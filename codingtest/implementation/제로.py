n = int(input())
stack = []
result = 0

count = 0
while count<n :
    num = int(input())
    if num!=0:
        stack.append(num)
    else:
        if len(stack)>0:
            stack.pop()
    count += 1

while True:
    if len(stack)==0:
        print(result)
        break
    result += stack.pop()
