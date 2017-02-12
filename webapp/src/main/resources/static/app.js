/**
 * Created by Sharuru on 2017/2/12 0012.
 */
$(document).ready(function () {
    function format(d) {
        return '<table cellpadding="6" cellspacing="0" border="0" style="padding-left:50px;">' +
            '<tr>' +
            '<td><b>Target User:&nbsp;&nbsp;</b></td>' +
            '<td>' + d.affecteduser+ '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Request App:&nbsp;&nbsp;</b></td>' +
            '<td>' + d.app + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Subject:&nbsp;&nbsp;</b></td>' +
            '<td>' + d.subject + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>File Link:&nbsp;&nbsp;</b></td>' +
            '<td>' + d.link + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>File Type:&nbsp;&nbsp;</b></td>' +
            '<td>' + d.objectType + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>File ID:&nbsp;&nbsp;</b></td>' +
            '<td>' + d.objectId + '</td>' +
            '</tr>' +
            '</table>';
    }


    $('#activity-table tfoot th').each(function () {
        var title = $(this).text();
        if(title != ''){
            $(this).html('<input type="text" class="form-control input-sm" style="width:100%;" placeholder="Search ' + title + '" />');
        }
    });

    var table = $('#activity-table').DataTable({
        'ajax': '/data/activities',
        'serverSide': true,
        "order": [[2, "desc"]],
        columns: [
            {
                "className": 'details-control',
                "orderable": false,
                "data": null,
                "defaultContent": ''
            }, {
                data: 'id'
            }, {
                data: 'timestamp',
                render: function (data, type, row) {
                    return new Date(data * 1000).toLocaleString();
                }
            }, {
                data: 'type'
            }, {
                data: 'user'
            },{
                data: 'file'
            }]
    });

    table.columns().every(function () {
        var that = this;

        $('input', this.footer()).on('keyup change', function () {
            if (that.search() !== this.value) {
                that
                    .search(this.value)
                    .draw();
            }
        });
    });

    $('#activity-table tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row(tr);

        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child(format(row.data())).show();
            tr.addClass('shown');
        }
    });

    $('#activity-table tfoot tr').appendTo('#activity-table thead');

    $('#activity-table_filter').remove();
});