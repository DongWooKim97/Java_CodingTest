l = []
c = []
for i in range(10):
    l.append(int(input()))

for i in range(10):
    c.append((l[i] % 42))

c = set(c)
print(len(c))
