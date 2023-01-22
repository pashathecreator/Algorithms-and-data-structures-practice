from bisect import bisect_left, bisect_right


def main():
    n, m = map(int, input().split())
    starts_of_segments = []
    ends_of_segments = []
    for i in range(n):
        start, end = map(int, input().split())
        starts_of_segments.append(start)
        ends_of_segments.append(end)
    starts_of_segments.sort()
    ends_of_segments.sort()

    dots_coordinates = list(map(int, input().split()))
    for dot_coordinate in dots_coordinates:
        starts = bisect_right(starts_of_segments, dot_coordinate)
        ends = bisect_left(ends_of_segments, dot_coordinate)
        print(
            bisect_right(starts_of_segments, dot_coordinate) - bisect_left(ends_of_segments, dot_coordinate),
            end=' ')


if __name__ == '__main__':
    main()

