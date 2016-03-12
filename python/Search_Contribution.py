log = open('log', 'r')  # assume each log file only contains logs for 1 day and it's ordered
line = log.readline()
search = set()
signup = set()
contribute = set()
while line:
    url = line[49:]
    visitor = line[33:44]
    if url.startswith("/search"):
        search.add(visitor)
    elif url.startswith("/signup"):
        if search.__contains__(visitor):
            contribute.add(visitor)
        signup.add(visitor)
    line = log.readline()
print('a.', len(contribute) / len(search) * 100,
      '% of distinct visitors requesting a "/search" URL end up requesting a "/signup" URL later on the same day.')
print('b.', len(contribute) / len(signup) * 100,
      '% of distinct visitors requesting a "/signup" URL have requested a "/search" URL earlier on the same day.')
