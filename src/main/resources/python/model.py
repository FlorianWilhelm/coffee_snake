import numpy as np
import pandas as pd
from scipy import stats

stats.norm(10.,2.).rvs()
x = np.ones(10)
x *= 2.4
df = pd.DataFrame([1,2,3])

print(df)
print(np.sum(x))

from java.lang import System

s = 'Hello World'
System.out.println(s)
print(s)
print(s[1:-1])