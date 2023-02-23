a = int(input())
l = []

for i in range(a):
    count = 0
    s = 0
    l.append(input())
    for j in l[i]:
        if j == 'O':
            count += 1
            s += count
        else:
            count = 0
    print(s)
