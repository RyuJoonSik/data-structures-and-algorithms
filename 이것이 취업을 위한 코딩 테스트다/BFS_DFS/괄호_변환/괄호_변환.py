# def solution(p):
# 	return parse(p)
# def parse(p):
#     if p == '':
#         return ''
    
#     u = ''
#     v = ''
#     left = 0
#     right = 0
    
#     for i in range(len(p)):
#         if p[i] == '(':
#             left += 1
#         else:
#             right += 1
            
#         if left == right:
#             u = p[:i + 1]
#             v = parse(p[i + 1:])
#             break
    
#     if u[0] == '(':
#         u += v
#     else:
#         u = u[1:-1]
#         u_list = list(u)
#         for j in range (len(u_list)):
#             if u_list[j] == '(':
#                 u_list[j] = ')'
#             else:
#                 u_list[j] = '('
#         u = '(' + v + ')' + ''.join(u_list)
#     return u

from tabnanny import check


def balanced_index(p):
  count = 0
  for i in range(len(p)):
    if p[i] == '(':
      count += 1
    else:
      count -= 1
    if count == 0:
      return i

def check_proper(p):
  count = 0
  for i in p:
    if i == '(':
      count += 1
    else:
      if count == 0:
        return False
      count -= 1
    return True

def solution(p):
  answer = ''
  if p == '':
    return answer
  index = balanced_index(p)
  u = p[:index + 1]
  v = p[index + 1:]
  if check_proper(u):
    answer = u + solution(v)
  else:
    answer = '('
    answer += solution(v)
    answer += ')'
    u = list(u[1:-1])
    for i in range(len(u)):
      if u[i] == '(':
        u[i] = ')'
      else:
        u[i] = '('
    ansewr += ''.join(u)
  return answer