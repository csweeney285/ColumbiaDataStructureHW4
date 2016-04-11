Conor Sweeney - cjs2201
README.txt

Programming Problem 1

My program was compiled on eclipse. In my SpellChecker.java class it uses two .txt files. When I compile it the files exist in the src file hence that is reflected in the file path. This will need to be changed if it is compiled in another way.

The program converts the words.txt into a dictionary that is a HashSet. It reads the file and if the word does not already exist in the HashSet it is added. All words are converted to lowercase since there are some repeats in the words.txt file. Some words have both an uppercase and lowercase version.

The program reads the sample txt which in this case is filetospellcheck.txt and converts it into a string and separates the words. It keeps track of linenumber and checks to see if each word exists in the dictionary HashSet. If it does not it prints the linenumber word and that it does not exist in the console.

It then checks if adding a letter, removing a letter, or switching adjacent letters creates a word that is spelled correctly and then prints out the suggestions. If the program is run the output should be as follows:

1: check. is not in the dictionary
Suggestions:
check
2: pple is not in the dictionary
Suggestions:
apple
2: cicle is not in the dictionary
Suggestions:
icicle
chicle
circle
2: wordl is not in the dictionary
Suggestions:
word
world
3: shuld is not in the dictionary
Suggestions:
should
4: mak is not in the dictionary
Suggestions:
mack
mark
mask
make
ma
5: tp is not in the dictionary
Suggestions:
tap
tip
top
p
t
pt
7: mpple is not in the dictionary
Suggestions:
8: absance is not in the dictionary
Suggestions:
9: amature is not in the dictionary
Suggestions:
armature
mature
10: collaegue is not in the dictionary
Suggestions:
colleague

While check may be a correct word, the program does not remove punctuation so it is considered misspelled.


Programming 2:

This program was also compiled using eclipse. I took the frameworks given and modified them to work. The program KBestCounter takes in an integer value and creates a heap which is a PriorityQueue. When its count method is called it takes in another integer value and checks to see if the heap has less than k values. If it does than it adds the value. If not the heap checks to see if the min element is smaller than the new element. If it is the min element is replaced.

TestKBest is relatively unchanged. It takes in my adapted KBestCounter and returns the following result:

Inserting 1,2,3.
5-best should be [3,2,1]: [3, 2, 1]
Inserting another 2.
5-best should be [3,2,2,1]: [3, 2, 2, 1]
Inserting 4..99.
5-best should be [99,98,97,96,95]: [99, 98, 97, 96, 95]
Inserting 100, 20, 101.
5-best should be [101,100,99,98,97]: [101, 100, 99, 98, 97]
