data = input()

i0, i1 = 0, 0
for i in range(len(data)):
    if(i==0):
        if data[i] == '1':
            i0 += 1
        else:
            i1 += 1
    else:
        if data[i-1] != data[i]:
            if data[i] == '1':
                i0 += 1
            else:
                i1 += 1

print(min(i0, i1))