#######Problema 3

#from functional import seq
list = [1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8]

if __name__ == '__main__':
    #seq(list)\
    #    .filter(lambda x:x>4)

    #Eliminarea elementelor mai mici decat 5
    for a in list :
        if a < 5:
            list.remove(a)
    print(list)
    
    #Gruparea elementelor in perechi de cate 2
    l1 = []
    l2 = []
    i = 0
    for a in list:
        if i%2 == 0:
            l1.append(a)
        else:
            l2.append(a)
        i = i + 1
    res = zip(l1,l2)
    list = []
    for a,b in res:
        list.append((a,b))
    print(list)

    #Multiplicarea numerelor din perechi

    prod = []
    for (a,b) in list:
        prod.append(a*b)
    print(prod)


    #Sumarea elementelor din lista

    sum=0
    for a in prod:
        sum = sum + a

    print(sum)