1.roughly how many binary digits (bit) are required for the unsigned representation of:

1,000
1,000,000
1,000,000,000
1,000,000,000,000
8,000,000,000,000

1,000: 10 bits
1,000,000: 21 bits
1,000,000,000: 30 bits
1,000,000,000,000: 40 bits
8,000,000,000,000: 43 bits

2.My town has approximately 20,000 residences. How much space is required to store the names,
addresses, and a phone number for all of these (if we store them as characters)?

average lengths:
Name: 30 characters
Address: 50 characters
Phone number: 15 characters

Space for one residence = (30 characters for name) + (50 characters for address) + (15 characters for phone number) = 95 characters

Total space required = Space for one residence * Number of residences = 95 characters * 20,000 residences

Total space required = 1,900,000 characters

3. I’m storing 1,000,000 integers in a binary tree. Roughly how many nodes and levels can
I expect the tree to have? Roughly how much space will it occupy on a 32-bit architecture?

1,000,000 integers = 1,000,000 nodes in the binary tree.

The number of levels in a binary tree with n nodes can be approximated by log2(n).
In this case, log2(1,000,000) is approximately 19.93, around 20 levels.

Each integer occupies 4 bytes (32 bits).
On a 32-bit architecture, each memory address can reference 4 bytes (32 bits).
The space required for each node in the binary tree would be:
- 4 bytes for the integer value
- 4 bytes for the pointer to the left child node
- 4 bytes for the pointer to the right child node

Total space required for each node = 4 bytes + 4 bytes + 4 bytes = 12 bytes
Total space occupied = Number of nodes * Space required for each node
Total space occupied = 1,000,000 * 12 bytes
Total space occupied = 12,000,000 bytes

4. My copy of Meyer’s Object Oriented Software Construction has about 1,200 body pages.
Assuming no flow control or protocol overhead, about how long would it take to send it over an async 56k baud modem line?

Bytes per second = Baud rate / 8
Bytes per second = 56,000 / 8
Bytes per second = 7,000 bytes per second

Transmission time (in seconds) = File size (in bytes) / Bytes per second
Let's assume the book's file size is around 10 MB (approximately 10,000,000 bytes):
Transmission time (in seconds) = 10,000,000 bytes / 7,000 bytes per second
Transmission time (in seconds) ≈ 1,428.57 seconds

5. My binary search algorithm takes about 4.5mS to search a 10,000 entry array, 
and about 6mS to search 100,000 elements. How long would I expect it to take to search 
10,000,000 elements (assuming I have sufficient memory to prevent paging).

(T1 / 10,000) = (T2 / 100,000) = (T3 / 10,000,000)

Solving for T3:

T3 = (T2 / 100,000) * 10,000,000

T3 = (6 milliseconds / 100,000) * 10,000,000
T3 ≈ 60,000 milliseconds

6.  Unix passwords are stored using a one-way hash function: the original string is converted to the
‘encrypted’ password string, which cannot be converted back to the original string. One way to
attack the password file is to generate all possible cleartext passwords, applying the password
hash to each in turn and checking to see if the result matches the password you’re trying to crack.
If the hashes match, then the string you used to generate the hash is the original password
(or at least, it’s as good as the original password as far as logging in is concerned).
In our particular system, passwords can be up to 16 characters long, and there are 96 possible
characters at each position. If it takes 1mS to generate the password hash, is this a viable
approach to attacking a password?

Total possible passwords = 96^16 ≈ 7.958 × 10^31
Time to generate all possible hashes ≈ 1mS * 7.958 × 10^31 = 2.52 × 10^17 years.