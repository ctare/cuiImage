arr = [0x00, 0x5F, 0x87, 0xAF, 0xD7, 0xFF]


def get_place(num):
    if num == 0xff:
        return 5
    for index, i in enumerate(arr):
        if i > num:
            return index - (1 if num - arr[index - 1] <= i - num else 0)


def color(num):
    if num%0xa0a0a == 0x80808:
        return 232 + int((num - 0x080808) / 0xa0a0a)
    pos = 16
    for i in range(3):
        pos += get_place(num & 0xff) * 6**i
        num >>= 8
    return pos


def mkcl(num):
    return "[38;5;{}m".format(num)


def mkclb(num):
    return "[48;5;{}m".format(num)

if __name__ == "__main__":
    import sys
    back = False
    result = ""
    if len(sys.argv) == 0:
        print("please color num")
    else:
        args = sys.argv[1:]
        if args[0] == "-b":
            back = True
            args = args[1:]

        for arg in args:
            cn = color(int(arg, 16))

            try:
                if back:
                    result += mkclb(cn) + " "
                else:
                    result += mkcl(cn) + " "
            except:
                pass
    print(result)
