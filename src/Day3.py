with open('input_day_3.txt', 'r') as f:
    text_input_orig = f.read()


def part_b(text_input):
    segments_to_count = []
    new_segs = text_input.split("don't()")
    segments_to_count.append(new_segs[0])
    new_segs.pop(0)

    for seg in new_segs:
        if 'do()' in seg:
            lists = seg.split("do()")
            strings_to_count = ''.join(lists[1:])
            segments_to_count.append(strings_to_count)
    string_result = ''.join(segments_to_count)
    return string_result


def part_a(text_input):
    sum_a = 0
    numbers = [segment.split(')')[0] for segment in text_input.split('mul(')]

    for number in numbers:
        if number[0].isdigit() and number[-1].isdigit() and number.replace(',', '').isdigit():
            first, second = number.split(',')
            sum_a += (int(first) * int(second))
    return sum_a


print("Result part A: ", part_a(text_input_orig))  # 179834255
print("Result part B: ", part_a(part_b(text_input_orig)))  # 80570939
