a = int(input())
b = list(map(int, input().split()))
b.sort(reverse=True)
m = max(b)
for i in range(len(b)):
    b[i] = (b[i] / m) * 100

print('%.2f' % (sum(b)/len(b)))
