'''
Created on 04.08.2020

@author: Max Weise
'''

from task import Task
import CustomExceptions as cExcept
import json
# import os
from glob import iglob # Used to acces files by extension (in this case '.json')

# NOTE: TkInter or HTML with Python backend (Django / Flask)


def searchName(LIST, name):  # May not be useful, but good to have
    '''Searches for given name in LIST. Will return False if LIST doesnt contain the name, otherwise True'''
    for element in LIST:
        if element.name == name:
            return True

    return False


def createNewTask_fromJSON(LIST, JObject):
    '''Recreates all Task objects from .json file
    JObject gets passed as jsonlist, converted to list, when iterated, all tasks get created and appendet to LIST
    
    @author: Max Weise
    '''
    json_list = json.load(JObject)
    
    for json_object in json_list:
        t = Task(**json_object) # The values of all the keywords get passed to the Task definition
        LIST.append(t)


def createNewTask(LIST):
    '''Creates new task and returns the object'''
    name_of_task = input('Please input name of Task:\n>>> ')

    if name_of_task == 'MW_ADMIN':  # For Debugging | Should not be typed by User
        LIST.append(Task('A', 'p', 0))
        LIST.append(Task('B', 'p', 0))
        LIST.append(Task('C', 'p', 0))
        return

    module_of_task = input('Please input module of Task (p, c, d):\n>>> ')
    priority = input('Please input priority of Task (-1, 0, 1):\n>>> ')

    if searchName(LIST, name_of_task):
        raise cExcept.DuplicateException

    if not (priority == '-1' or priority == '0' or priority == '1'):
        priority = 0

    t = Task(name_of_task, module_of_task, priority)
    LIST.append(t)


def printToDoList(LIST):
    '''Auxiliary function to easily print a list of objects'''
    print('To-Do-List:')
    for x in LIST:
        print('\t>', x)

    print('\n' + 40 * '=' + '\n')


def deleteTask(LIST):
    '''User inputs name of task, function will find index of Task and deletes it using the del function'''

    if LIST == []:
        print('There are no tasks in the List\nYou might consider adding one first.')
        return

    userInput = input('Please give name of task to delete:\n>>> ')

    for x in LIST:
        if x.name == userInput:
            del(LIST[LIST.index(x)])  # Gets index of element, then deletes element at given index
            printToDoList(LIST)
            return

    raise cExcept.NotFoundException


def work_on_task(LIST):
    '''Selects task and starts the stopwatch'''

    if LIST == []:
        print('There are no tasks in the List\nYou might consider adding one first.')
        return

    user_selection = input('Select the task you want to work on:\n>>> ')

    for x in LIST:
        if x.name == user_selection:
            x.stoppwatch()
            return

    raise cExcept.NotFoundException


def test():
    pass


def main():
    
    # Declaration of necessary instances (List of commands, to do list)
    command_List = {
        'new' : createNewTask,
        'delete' : deleteTask,
        'work' : work_on_task,
        }    
    to_do_list = []  # List where all tasks get saved
    
    # Try loading all the Tasks from JSON file
    try:
        for save_file in iglob('*.json', recursive = True):
            with open(save_file) as json_file:
                createNewTask_fromJSON(to_do_list, json_file)
    except Exception as e: # Task wont be lost if exception occurs
        print(e)
    

# ======================================================================================

    while True:  # This is where the program actually runs
        try:
            if to_do_list != []:
                print(' ')
                printToDoList(to_do_list)

            userInput = input('>>> ')

            if userInput == 'exit':
                break
            else:
                command_List[userInput](to_do_list)
        except KeyError:
            print(f'The input \'{userInput}\' was invalid, please try again\n')
        except Exception as e:
            print(e.message)
            print('please try again\n')

# ======================================================================================

    # TODO: How to include realtive path in python? | Suggestion: os.somethinsomethin

    # All tasks will be written in JSON file
    with open('saved_objects.json', 'w+') as f:
        json.dump([task_object.toDict() for task_object in to_do_list], f)
    
    print('END')


if __name__ == '__main__':
    main()
    # test()
