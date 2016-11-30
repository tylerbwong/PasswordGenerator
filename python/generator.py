#!/usr/bin/python
import sys, random, string

default_length = 10;

length = int(sys.argv[1]) if len(sys.argv) > 0 else default_length

rand = random.SystemRandom()

characters = string.ascii_lowercase + string.ascii_uppercase + string.digits + string.punctuation

print str().join(rand.choice(characters) for _ in xrange(length))
