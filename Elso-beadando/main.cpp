#include "header.h"

using namespace std;


int main()
{
    vector<vector<int> > data;
    fstream fin("input.txt");

    try
    {
        fin >> data;
        for(int i=0; i<data.size(); ++i)
        {
            for (int j=0; j<data.at(i).size(); ++j)
            {
                std::cout << data[i][j] << " ";
            }
            cout << endl;
        }
        int maxNulla = maxKiv(data);
        if (maxNulla == 0)
        {
            cout << "Nem volt nulla pontos versenyzo" << endl;
        }
        else
        {
            cout << maxNulla << endl;
        }


    }
    catch (Exc e)
    {
        switch(e)
        {
        case NEGATIVE_SIZE:
            cout << "NEGATIVE_SIZE" << endl;
            break;
        case WRONG_INPUT:
            cout << "WRONG_INPUT" << endl;
            break;
        case WRONG_VALUE:
            cout << "WRONG_VALUE" << endl;
            break;
        }
    }


    return 0;
}
