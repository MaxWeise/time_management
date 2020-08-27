'''
Created on 04.08.2020

@author: Max Weise
'''

from task import Task
import CustomExceptions as cExcept
import json

# NOTE: TkInter or HTML with Python backend (Django / Flask)


def searchName(LIST, name):  # May not be useful, but good to have
    '''Searches for given name in LIST. Will return False if LIST doesnt contain the name, otherwise True'''
    for element in LIST:
        if element.name == name:
            return True

    return False


# TODO: JSON savestates of the tasks
# TODO: write jobj to file and get jobj from file
def createNewTask_fromJSON(LIST):
    JObject = '{ "name":"TASK1", "modul":"p", "time":60, "WIP":false, "priority":0}'
    
    j_dict = json.loads(JObject)
    
    t = Task(j_dict['name'], j_dict['modul'], j_dict['priority'], j_dict['time'], j_dict['WIP'])
    LIST.append(t)


def createJSONObject(task_object):
    x = task_object.toDict()
    
    jobj = json.dumps(x)
    
    return jobj
    pass


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
    liste = []
    createNewTask_fromJSON(liste)
    
    printToDoList(liste)

    print(createJSONObject(liste[0]))


def main():
    # TODO: JSON load here
    
    command_List = {
        'new' : createNewTask,
        'delete' : deleteTask,
        'work' : work_on_task,
        }
    to_do_list = []  # List of all the task objects

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

    # TODO: write JSONObjects to file here
    
    print('END')


if __name__ == '__main__':
    # main()
    test()
