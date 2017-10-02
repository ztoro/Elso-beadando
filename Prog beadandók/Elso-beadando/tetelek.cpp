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

istream& operator>>(istream& in, vector<int> &a)
{
    int size;
    in >> size;
    if(size < 0)
    {
        throw NEGATIVE_SIZE;
    }
    if(in.fail())
    {
        throw WRONG_INPUT;
    }

    for (int i=0; i<size; ++i)
    {
        int temp;
        in >> temp;
        if(in.fail())
        {
            throw WRONG_INPUT;
        }
        if (temp > 10 || temp < 0)
        {
            throw WRONG_VALUE;
        }
        a.push_back(temp);

    }
    return in;
}
