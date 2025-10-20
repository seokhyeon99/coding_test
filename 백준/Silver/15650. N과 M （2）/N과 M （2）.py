import sys
input = sys.stdin.readline

# n: The range of natural numbers from 1 to N.
# m: The number of integers to choose for the combination.
n, m = map(int, input().split())

num = [] # Create a list 'num' to store the numbers from 1 to N.
for i in range(1, n + 1):
    num.append(i)

tmp = [0] * 8 # A temporary list to store a generated combination.
loc = 0 # A variable to store the starting index 

# A recursive function to generate and print combinations.
# quan: The remaining number of integers to choose.
# idx: The starting index in the 'num' list for the current search.
def comb_print(quan, idx):
    # [Base Case 1] If the number of available elements (from num[idx:]) is less than
    # the number of elements we still need to choose (quan), it's impossible to form a combination.
    # So, the function returns.
    if len(num[idx:]) < quan:
        return 0

    # [Base Case 2] If the number of available elements is exactly equal to the number we need to choose,
    # we must select all the remaining elements to complete the combination.
    elif len(num[idx:]) == quan:
        # Fill the remaining slots in the 'tmp' list with the available numbers.
        for i in range(quan):
            # m-quan: The starting position in 'tmp' for the current elements.
            tmp[m - quan + i] = num[idx + i]
        
        # Print the completed combination stored in the 'tmp' list.
        for j in range(m):
            print(tmp[j], end=' ')
        print()

    # [Recursive Step] If there are more available numbers than we need to choose.
    else: # len(num[idx:]) > quan
        # If we only need to choose one more number (deepest stage of recursion).
        if quan == 1:
            # Iterate through the remaining available numbers, place each one in the last slot,
            # and print the completed combination.
            for i in num[idx:]:
                tmp[m - quan] = i # Same as tmp[m-1]
                for j in range(m):
                    print(tmp[j], end=' ')
                print()
        # If we need to choose more than one number.
        else:
            # This loop iterates through all possible choices for the current position.
            for i in range(len(num[idx:])):
                # Select the number num[idx+i] and place it in the current slot (m-quan) of 'tmp'.
                tmp[m - quan] = num[idx + i]
                
                # Make a recursive call to choose the next number.
                # The number of elements to choose decreases by 1 (quan-1).
                # The next search must start from the index after the currently chosen one (idx+i+1)
                # to ensure the combination is in ascending order and without duplicates.
                comb_print(quan - 1, idx + i + 1)
                
comb_print(m, loc)
