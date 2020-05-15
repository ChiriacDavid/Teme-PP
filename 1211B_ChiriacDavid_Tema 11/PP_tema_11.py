from random import randrange
import asyncio
import sys


@asyncio.coroutine
def first_coroutine(future, n):
    count = 0
    for i in range(0, n+1):
        count += i
    yield from asyncio.sleep(4)
    future.set_result(f'1st coroutine ({n} - suma) result = {count}')

@asyncio.coroutine
def second_coroutine(future, n):
    count=0
    for i in range(0, n+1):
        count += i
    yield from asyncio.sleep(4)
    future.set_result(f'2nd coroutine  ({n} - suma) result = {count}')

@asyncio.coroutine
def second_coroutine(future, n):
    count=0
    for i in range(0, n+1):
        count += i
    yield from asyncio.sleep(4)
    future.set_result(f'3rd coroutine  ({n} - suma) result = {count}')


@asyncio.coroutine
def second_coroutine(future, n):
    count=0
    for i in range(0, n+1):
        count += i
    yield from asyncio.sleep(4)
    future.set_result(f'4th coroutine  ({n} - suma) result = {count}')

def got_result(future):
    print(future.result())

if __name__ == '__main__':
    num1 = randrange(100)
    num2 = randrange(100)
    num3 = randrange(100)
    num4 = randrange(100)

    loop = asyncio.get_event_loop()
    future1 = asyncio.Future()
    future2 = asyncio.Future()
    future3 = asyncio.Future()
    future4 = asyncio.Future()

    tasks = [first_coroutine(future1, num1), second_coroutine(future2, num2), second_coroutine(future3, num3), second_coroutine(future4, num4)]

    future1.add_done_callback(got_result)
    future2.add_done_callback(got_result)
    future3.add_done_callback(got_result)
    future4.add_done_callback(got_result)

    loop.run_until_complete(asyncio.wait(tasks))
    loop.close()


