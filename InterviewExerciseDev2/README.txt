Interview:  Java coding exercise

Directions:
. Code in Java
. You are expected to complete this exercise by yourself.  Do not discuss with others ( applies to both online and offline communication )
. Feel free to use the Internet as a reference, e.g. Java documentation  


-------------------------------
PART I
-------------------------------

The goal is to design a bidding system that will bid on a certain percentage of requests based on an attribute of the request.

Requirement: 
- Weigh a sequence of random integers using the last digit of the number as the weighing attribute. The weight should be the digit x 10.  
- For example, numbers ending in 4 should be accepted 40% of the time, numbers ending in 9 should be accepted 90% of the time. 
- So after some iterations, the theoretical results should be: 1 is allowed 10% of the time, 2 is allowed 20% of the time, etc.
- Write some test code to validate that your program is working properly.

Example Output for 100,000 iterations:

last_digit	total_bids		accepted_bids
0			10106			0
1			10028			955
2			9963			1961
3			10084			3074
4			9942			4044
5			9837			4937
6			10002			6080
7			10024			7004
8			10021			7941
9			9993			9020


-------------------------------
Part II
-------------------------------

The goal is to design a software control system that will control the rate of bid requests.

Requirement: 
- Create a simple loop that counts the number of iterations and calculates the rate (rate= count/sec). 
- Add to the loop a sleep function that will control the rate such that the count is incremented at approximately 125 times per second.
- Write some test code to validate that your program is working properly.

Example Output:

...
Count=3316 Rate=127.025 Elapsed Time=26.105 secs
Count=3317 Rate=127.01 Elapsed Time=26.116 secs
Count=3318 Rate=126.927 Elapsed Time=26.141 secs
Count=3319 Rate=126.766 Elapsed Time=26.182 secs
Count=3320 Rate=126.539 Elapsed Time=26.237 secs
Count=3321 Rate=126.235 Elapsed Time=26.308 secs
Count=3322 Rate=125.862 Elapsed Time=26.394 secs
Count=3323 Rate=125.425 Elapsed Time=26.494 secs
Count=3324 Rate=124.915 Elapsed Time=26.61 secs
...