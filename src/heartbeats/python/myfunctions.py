    
def convert_delta(time_delta):
    """(time_delta type) -> int

    Konwertuje liczbę dni i sekund zawartych w typie danych timedelta,
    a następnie zwraca ich wartość podaną w minutach.

    >>> convert_delta(days, seconds)
    minutes
    >>> convert_delta(1, 0)
    1440
    >>> convert_delta(2, 360)
    2886
    """

    days, seconds = time_delta.days, time_delta.seconds
    minutes = (days * 24 * 60) + (seconds // 60)
    return minutes
