def process_numbers(numbers):
    is_increasing = numbers[1] > numbers[0]
    for i in range(len(numbers) - 1):
        if is_increasing:
            difference = numbers[i + 1] - numbers[i]
        else:
            difference = numbers[i] - numbers[i + 1]

        if difference < 1 or difference > 3:
            return False

        if i == len(numbers) - 2:
            return True

    return False

def main():
    sum_b = 0
    with open('src/input_day_2.txt', 'r') as file:
        lines = file.readlines()

    for line in lines:
        numbers = list(map(int, line.split()))
        is_valid_line = False
        for i in range(len(numbers)):
            new_list = numbers[:i] + numbers[i+1:]
            if process_numbers(new_list):
                is_valid_line = True
                break
        if is_valid_line:
            sum_b += 1

    print(f"\nTotal Sum part B: {sum_b}")

if __name__ == "__main__":
    main()