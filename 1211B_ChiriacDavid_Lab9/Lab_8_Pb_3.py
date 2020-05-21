import types

def decorator_cu_argumente(before_fct, after_fct, replacement_fct=None):
    def wrap(f):
        def wrapped_f(*args, **kwargs):
            if isinstance(before_fct, types.FunctionType):
                before_fct()
            if replacement_fct and isinstance(replacement_fct, types.FunctionType):
                output = replacement_fct(*args, **kwargs)
            else:
                output=f(*args, **kwargs)
            if isinstance(after_fct, types.FunctionType):
                after_fct()
            return output
        return wrapped_f
    return wrap

def before():
    print("Before")
def after():
    print("After")
def replacement(*args, **kwargs):
    print("Replacement")
    return "replaced"

@decorator_cu_argumente(before_fct=before, after_fct=after, replacement_fct=replacement)
def func0(name, question):
    print("func0")
    return f"Hello {name}, {question}"

@decorator_cu_argumente(before_fct=before, after_fct=after)
def func1(name):
    print("func1")
    return f"Hello {name}"

if __name__ == '__main__':
    print("Returned:",func0("Ion Popescu","how are you?"))
    print("Returned:",func0("Ion Popescu"))