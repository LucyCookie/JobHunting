log = open('log', 'r')  # assume each log file only contains logs for 1 day and it's ordered
line = log.readline()
total = {}
while line:
    hr = line[16:18]
    if total.__contains__(hr):
        count = total[hr]
        count += 1
        total[hr] = count
    else:
        total[hr] = 1
    line = log.readline()
for i in sorted(total.items()):
    print(i[0], ",", i[1])
