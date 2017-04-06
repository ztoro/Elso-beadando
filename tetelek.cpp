#include "header.h"



int& nullaCount (const vector<int> &v)
{
    int nullaDb = 0;
    for(int i = 0; i < v.size(); ++i)
    {
        if (v[i] == 0)
        {
            nullaDb++;
        }
    }
    return nullaDb;
}


int maxKiv(const vector<vector<int> > &a)
{
    int maxNulla = 0;
    int maxIndex = 0;
    for (int i = 0; i < a.size(); ++i)
    {
        int temp = nullaCount(a[i]);
        if (temp > maxNulla)
        {
            maxNulla = nullaCount(a[i]);
            maxIndex = i+1;
        }
    }
    return maxIndex;
}
