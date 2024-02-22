import React from 'react';
import {Table, TableContainer, TableHead, TableRow, TableCell, TableBody, Paper} from '@mui/material';

const AliensTable = ({ data }) => {

    const columns = [
        { id: 'id', label: 'Id', minWidth: 100 },
        { id: 'name', label: 'Name', minWidth: 150 },
        { id: 'commanderId', label: 'Commander Id', minWidth: 100 },
        { id: 'commanderName', label: 'Commander Name', minWidth: 150 },
        { id: 'weapon', label: 'Weapon', minWidth: 150 }
    ];

    return (
        <TableContainer component={Paper}>
            <Table>
                <TableHead>
                    <TableRow>
                        {columns.map((column) => (
                            <TableCell key={column.id} style={{ minWidth: column.minWidth }}>
                                {column.label}
                            </TableCell>
                        ))}
                    </TableRow>
                </TableHead>
                <TableBody>
                    {data.map((row, rowIndex) => (
                        <TableRow key={rowIndex}>
                            {columns.map((column) => (
                                <TableCell key={column.id}>{row[column.id]}</TableCell>
                            ))}
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
};

export default AliensTable;
