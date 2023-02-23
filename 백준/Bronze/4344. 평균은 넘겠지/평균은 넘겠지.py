
case = int(input())

for _ in range(case):
    l = list(map(int, input().split()))
    avg = sum(l[1:]) / l[0]
    count = 0

    for j in l[1:]:
        if j > avg:
            count += 1

    x = (count / l[0]) * 100
    print(f'{x:.3f}%')
