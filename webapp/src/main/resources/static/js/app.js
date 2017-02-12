/**
 * Created by Sharuru on 2017/2/12 0012.
 */
$(document).ready(function () {
    $('#activity-table tfoot th').each(function () {
        var title = $(this).text();
        $(this).html('<input type="text" placeholder="Search ' + title + '" />');
    });

    var table = $('#activity-table').DataTable({
        'ajax': '/data/activities',
        'serverSide': true,
        "order": [[1, "desc"]],
        columns: [{
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
        }, {
            data: 'affecteduser'
        }, {
            data: 'app'
        }, {
            data: 'subject'
        }, {
            data: 'file'
        }, {
            data: 'link'
        }, {
            data: 'objectType'
        }, {
            data: 'objectId'
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

    $('#activity-table tfoot tr').appendTo('#activity-table thead');

    $('#activity-table_filter').remove();
});