def getSum(data):
    total = 0
    for i in data:
        total += i
    return total
    
def getMean(data):
    return getSum(data)/len(data)
    
def getMax(data): # 2,6,8,11
    maxV = data[0]
    for i in data[1:]:
        if i > maxV:
            maxV = i
    return maxV
    
def getMin(data):
    minV = data[0]
    for i in data[1:]:
        if i < minV:
            minV = i
    return minV
    
def getTwoSum(num2, num1=1): #num1이 더 큰값이 왔을때...
    total = 0
    if num1>num2:
        num1, num2 = num2, num1 #두수를 스왑시킴
    for i in range(num1, num2+1):
        total += i
    return total