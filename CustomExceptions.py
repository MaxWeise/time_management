'''
Created on 15.08.2020

@author: Max Weise
'''

'''This file contains all custom exceptions used in the 'main.py' module'''


class NameException(Exception):
    message = '\n === Name may not contain spaces === \n'


class NotFoundException(Exception):
    message = '\n === Element not found === \n'


class DuplicateException(Exception):
    message = '\n === The element is a duplicate of some sort. Check for name === \n'

if __name__ == '__main__':
    print('This module contains the custom exceptions raised in the main program.\nTo run the program, run the main.py module' )