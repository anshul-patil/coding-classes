import random

def ask_name():
    print("What is your name?")
    name = raw_input()
    return name.capitalize()

def pick_number(high):
    pick = random.randint(1, high)
    return pick

def start_playing(person, high, guess):
    print("Ok %s let's play a guessing game" % (person))
    print("I'm thinking of a number between 1 and %d" % (high))
    print("Computer has picked %d" % (guess))

def main():
    gamer = ask_name()
    maximum = 20
    guess = pick_number(maximum)
    start_playing(gamer, maximum, guess)
    print("Bye %s" % (gamer))
    

main()

