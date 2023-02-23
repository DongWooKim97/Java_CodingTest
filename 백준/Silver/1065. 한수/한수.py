def h(x):
    count = 0
    if len(x) >= 3:
        if int(x[0])-int(x[1]) != int(x[1]) - int(x[2]):
            count += 1

    return count

n = int(input())

for i in range(1, n+1):
    a = h(str(i))
    n -= a

print(n)
