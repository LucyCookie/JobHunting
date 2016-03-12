log = open('log', 'r')  # assume each log file only contains logs for 1 day and it's ordered
line = log.readline()
total = {}
while line:
    hr = line[16:18]
    visitor = line[33:44]
    if total.__contains__(hr):
        visitors = total[hr]
        visitors.add(visitor)
    else:
        visitors = set()
        visitors.add(visitor)
        total[hr] = visitors
    line = log.readline()
for i in sorted(total.items()):
    print(i[0], ",", len(i[1]))
