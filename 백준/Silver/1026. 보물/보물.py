n = int(input())
data_a = list(map(int, input().split()))
data_b = list(map(int, input().split()))
total = 0

for i in range(n):
    total += min(data_a) * max(data_b)
    data_a.pop(data_a.index(min(data_a)))
    data_b.pop(data_b.index(max(data_b)))

print(total)