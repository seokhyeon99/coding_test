import sys
input = sys.stdin.readline

n, m = map(int, input().split())
num = list(map(int, input().split()))

# --- Global lists to store intermediate and final results ---
list_per = []       # Temp list to build one combination
result_comb = []    # Stores all generated combinations

result_mix = []     # Stores all final permutations
list_mix = []       # Temp list to build one permutation
visited = [0] * m   # Visited array for the permutation function (size m)

# --- Function to generate permutations of a given list ---
def mix(lst):
    for i in range(len(lst)):
        if len(list_mix) == m:
            result_mix.append(list_mix.copy() )
            return                   

        # Recursive Step: if the element at index 'i' hasn't been used yet
        if not visited[i]:
            visited[i] = 1              # Mark as visited
            list_mix.append(lst[i])     # Add element to the current permutation
            
            mix(lst)                    # Recursive call
            
            # Backtrack: undo the choices for the next iteration
            list_mix.pop()              # Remove the element
            visited[i] = 0              # Unmark as visited
            
# --- Function to generate combinations ---
def comb(idx):
    if len(list_per) == m:
        tmp = list_per.copy()
        result_comb.append(tmp)
        return

    # Recursive Step: iterate from the current index 'idx' to N
    for i in range(idx, n):
        list_per.append(num[i])  # Add the number to the current combination
        comb(i+1)                # Recursive call for the next element
        list_per.pop()           # Backtrack: remove the number

# --- Main execution logic ---
comb(0) # Start generating combinations from index 0

# For each combination found, generate all its permutations
for i in result_comb:
    mix(i)

# Sort the final list of all permutations lexicographically and print each one
for i in sorted(result_mix):
    print(*i)