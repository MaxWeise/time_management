'''
Created on 05.08.2020

@author: Max Weise
'''
from time import time  # Used for the stoppwatch
from datetime import timedelta  # Convert seconds to format h:mm:ss
import CustomExceptions as cExcept

''' This file contains the Task class. The executable program is written in the 'main.py' file.

#=== -> is used to get rid of indentation guide (closing bracket, so to speak)
'''

# NOTE: Not shure if id for each task is necessary / good idea 


class Task(object):
    ''' Blueprint for a task
    @author: Max Weise

    name : str                -> descriptive name of the task
    module : char             -> code, plan, debug
    time : int                -> time spent on given task
    work_in_progress : bool   -> is the task in progress?
    priority : int [-1, 0, 1] -> 0 = normal, the higher the number, the higher the priority
    '''

    def __init__(self, name, module, priority=0, time=0, work_in_progress=False):
        self.name = ''
        self.changeName(name)

        self.module = module
        self.time = time
        self.wip = work_in_progress
        self.priority = priority
#         self.unique_identification_number = id(self)

    def __str__(self):
        # getting name of the module
        if self.module == 'c':
            m = 'code'
        elif self.module == 'd':
            m = 'debug'
        else:
            m = 'plan'

        return f'[{self.priority}] \'{self.name}\' ({m} | T: {timedelta(seconds=self.time)})'
#        return f'[{self.priority}] \'{self.name}\' ({m} | T: {timedelta(seconds=self.time)}) <{self.unique_identification_number}>'

    def toDict(self):
        '''Returns the object as a dictionary'''
        list_of_keys = ['name', 'module', 'time', 'priority', 'work in progress']
        list_of_values = [self.name, self.module, self.time, self.priority, self.wip]

        taskDict = dict(zip(list_of_keys, list_of_values))
        return taskDict

    def changeName(self, name_to_change):
        '''Change name of task. Name may not contain spaces'''
        invalid_name = name_to_change  # To check if name has been modified

        try:
            if name_to_change.__contains__(' '):
                raise cExcept.NameException

        except Exception as e:
            print(e.message)
            name_to_change = name_to_change.replace(' ', '_')

        finally:
            if invalid_name != name_to_change:
                print(f'\'{invalid_name}\' was invalid, new name is : \'{name_to_change}\'')

            self.name = name_to_change

    def stoppwatch(self):
        ''' Get the time used for a specific task
        @author: Max Weise
        returns time in seconds
        Use 'timedelta' to get the h:mm:ss format
        '''
        input('Press enter to start the stopwatch')
        print('Started stopwatch')

        t0 = time()

        input('To stop, press enter')

        t1 = time()
        delta_t = t1 - t0

        delta_t = int(delta_t)

        self.time += delta_t
        print(f'Stopwatch: {timedelta(seconds=delta_t)} | Total: {timedelta(seconds=self.time)}')


if __name__ == '__main__':
    print('This module is used for declarations only.\nTo run the program, please use the \'main.py\' file')
