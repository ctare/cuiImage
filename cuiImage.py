#/usr/bin/python3
import io
import requests
from PIL import Image
import numpy as np
from matplotlib import pylab as plt
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


def resize(img, to_size):
    size = img.size
    if size[0] < size[1]: # vertical
        ratio = size[1] / to_size
        img = img.resize((int(size[0] // ratio), to_size))
    else: # oblong
        ratio = size[0] / to_size
        img = img.resize((to_size, int(size[1] // ratio)))
    return img


def load_img(url):
    return Image.open(io.BytesIO(requests.get(url).content))


def create_data(img, size=None):
    img = load_img(img) if type(img) == str else img

    if size == None: img = np.array(img)
    else: img = np.array(resize(img, int(size)))

    result = ""
    for line in [[(color[0] << 16) | (color[1] << 8) | color[2] for color in column] for column in img]:
        for i in line:
            result += mkcl(color(i)) + "##"
        result += "\n"
    return result


if __name__ == "__main__":
    import sys
    def display(filename, url, size=180):
        print(create_data(url, size))

    display(*sys.argv)
