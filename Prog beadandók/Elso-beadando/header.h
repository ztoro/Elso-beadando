#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

#include <iostream>
#include <vector>
#include <fstream>



using namespace std;

enum Exc
{
    NEGATIVE_SIZE,
    WRONG_INPUT,
    WRONG_VALUE
};


template<typename T>
istream& operator>>(istream& in, vector<T> &a)
{
    int size;
    in >> size;
    if (size < 0)
    {
        throw NEGATIVE_SIZE;
    }
    if(in.fail())
    {
        throw WRONG_INPUT;
    }

    for (int i = 0; i < size; ++i)
    {
        T temp;
        in >> temp;
        if (in.fail())
        {
            throw WRONG_INPUT;
        }

        a.push_back(temp);
    }

    return in;
}



int maxKiv(const vector<vector<int> > &data);
int& nullaCount (vector<int> &a);

#endif // HEADER_H_INCLUDED

